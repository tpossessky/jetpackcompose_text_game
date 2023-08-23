package com.game.logisticscompanycompose.feature_game_management.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.game.logisticscompanycompose.feature_game_management.presentation.GameManagementClickEvent
import com.game.logisticscompanycompose.feature_game_management.presentation.view_models.LoadGameListViewModel

@Composable
fun LoadGameList(
    modifier: Modifier = Modifier,
    viewModel: LoadGameListViewModel = hiltViewModel(),
    paddingValues: PaddingValues = PaddingValues(),
    onSelectCompany : (Int) -> Unit
) {
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()
    val showDeleteDialog = viewModel.showDeleteDialog.value

    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = {
                viewModel.showDeleteDialog.value = false
            },
            title = {
                Text(text = "Delete Save Game")
            },
            text = {
                Text("Are you sure you'd like to delete this?")
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.showDeleteDialog.value = false
                        viewModel.onEvent(GameManagementClickEvent.ConfirmDelete)
                    }) {
                    Text("Delete")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        viewModel.showDeleteDialog.value = false
                    }) {
                    Text("Cancel")
                }
            }
        )
    }

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ){
        itemsIndexed(state.games){index, game ->
            LoadGameItem(company = game, color = state.colors[index]) {
                    event ->
                when (event) {
                    is GameManagementClickEvent.GameManagementClickDelete -> {
                        viewModel.idToDelete.value = event.id
                        viewModel.showDeleteDialog.value = true
                    }
                    is GameManagementClickEvent.GameManagementClickCompany -> {
                        onSelectCompany(event.id)
                    }
                    else -> {}
                }
            }
        }
    }
}