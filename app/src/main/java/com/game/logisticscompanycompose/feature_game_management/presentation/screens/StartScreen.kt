package com.game.logisticscompanycompose.feature_game_management.presentation.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.game.logisticscompanycompose.feature_game_management.presentation.components.CreateGameDialog
import com.game.logisticscompanycompose.feature_game_management.presentation.view_models.StartScreenViewModel
import com.game.logisticscompanycompose.main.navigation.StartScreenNavigationItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel : StartScreenViewModel = hiltViewModel(),
    onCompanyCreated: (Int) -> Unit
) {
    val textStyle = TextStyle(
        fontWeight = FontWeight.Black,
        color = Color.White,
        fontSize = 16.sp
    )
    val showCreateDialog = viewModel.showCreateDialog.value
    val exceptionType = viewModel.exception.value

    // Observe the newCompanyId Flow using LaunchedEffect
    LaunchedEffect(viewModel.newCompanyId) {
        viewModel.newCompanyId.collect { companyId ->
            if (companyId != null) {
                Log.wtf("FLOW", "ID : $companyId")
                onCompanyCreated(companyId)
            }
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) {
        // Content
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Logistics Company Simulator",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF0061ff)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 32.dp
                    ),
                    shape = RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 32.dp, vertical = 32.dp)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        ClickableText(
                            text = AnnotatedString("New Game"),
                            style = textStyle,
                            onClick = {
                                viewModel.showCreateDialog.value = true
                            }
                        )
                        ClickableText(
                            text = AnnotatedString("Load Game"),
                            style = textStyle,
                            onClick = {
                                navController.navigate(StartScreenNavigationItem.LoadGame.route)
                            }
                        )
                        ClickableText(
                            text = AnnotatedString("Tutorial"),
                            style = textStyle,
                            onClick = {
                                navController.navigate(StartScreenNavigationItem.Tutorial.route)
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(.75f))
        }
        if (showCreateDialog) {
            CreateGameDialog(
                onConfirm = { company ->
                    viewModel.onCreateCompany(company)
                },
                onDismissRequest = { viewModel.showCreateDialog.value = false },
                errorType = exceptionType,
            )
        }
    }
}