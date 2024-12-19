package com.example.ucp2.ui.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2.ui.customwidget.CustomBottomAppBar
import com.example.ucp2.ui.customwidget.TopAppBar
import com.example.ucp2.ui.viewModel.HomeDosenViewModel
import com.example.ucp2.ui.viewModel.PenyediaViewModel

@Composable
fun HomeDosenView(
    viewModel: HomeDosenViewModel = viewModel(factory = PenyediaViewModel.Factory),
    onAddMhs: () -> Unit = { },
    onDosen: () -> Unit = { },
    onMK: () -> Unit = { },
    onHome: () -> Unit = { },
    onBack:() -> Unit,
    onDetailClick: (String) -> Unit = { },
    modifier: Modifier = Modifier ) {

    Scaffold(topBar = {
        TopAppBar(
            judul = "Daftar Dosen",
            showBackButton = true,
            onBack = onBack,
            modifier = modifier
        )
    },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddMhs,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Tambah Dosen"
                )
            }
        },

        bottomBar = {
            CustomBottomAppBar(
                onHomeClick = onHome,
                onDosenClick =onDosen,
                onMkClick = onMK,
                selectedItem = 0
            )
        },) { innerPadding ->
        val homeUiState by viewModel.homeDsnUiState.collectAsState()

        BodyHomeDosenView(
            homeUiState = homeUiState,
            onClick = {
                onDetailClick(it)
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}
