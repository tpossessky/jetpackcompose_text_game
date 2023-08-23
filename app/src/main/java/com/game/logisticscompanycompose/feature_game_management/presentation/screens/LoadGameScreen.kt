package com.game.logisticscompanycompose.feature_game_management.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.game.logisticscompanycompose.feature_game_management.presentation.components.LoadGameList
import com.game.logisticscompanycompose.feature_game_management.presentation.view_models.LoadGameViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoadGameScreen(
    modifier: Modifier = Modifier,
    viewModel: LoadGameViewModel = hiltViewModel(),
    navController: NavController,
    onLoadGame : (Int) -> Unit
) {
//    val showCreateDialog = viewModel.showCreateDialog.value
//    val exceptionType = viewModel.exception.value

    Scaffold(
        modifier = modifier,
//        floatingActionButtonPosition = FabPosition.End,
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = {
//                    viewModel.showCreateDialog.value = true
//                }, containerColor = MaterialTheme.colorScheme.secondary, shape = CircleShape
//            ) {
//                Icon(imageVector = Icons.Default.Add, contentDescription = "Save")
//            }
//        },
        topBar = {
            TopAppBar(
                title = { Text(text = "Load Game") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    ) {
//        if (showCreateDialog) {
//            CreateGameDialog(
//                onConfirm = { company ->
//                    viewModel.onCreateCompany(company)
//                },
//                onDismissRequest = { viewModel.showCreateDialog.value = false },
//                showDialog = true,
//                errorType = exceptionType,
//            )
//        }
        LoadGameList(paddingValues = it){ id ->
            onLoadGame(id)
        }
    }
}

