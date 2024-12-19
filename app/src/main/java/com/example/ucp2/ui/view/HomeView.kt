package com.example.ucp2.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2.R
import com.example.ucp2.ui.customwidget.CustomBottomAppBar
import com.example.ucp2.ui.viewModel.HomeViewModel
import com.example.ucp2.ui.customwidget.TopAppBar
import com.example.ucp2.ui.viewModel.HomeUiState
import com.example.ucp2.ui.viewModel.PenyediaViewModel

@Composable
fun HomeView(
    onDetailClick: (String) -> Unit = { },
    onDosen: () -> Unit = { },
    onMK: () -> Unit = { },
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    Scaffold(
        topBar = {
            TopAppBar(
                judul = "SI Database",
                showBackButton = false,
                onBack = { },
                modifier = modifier
            )
        },
        bottomBar = {
            CustomBottomAppBar(
                onHomeClick = {  },
                onDosenClick =onDosen,
                onMkClick = onMK,
                selectedItem = 0
            )
        },

        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                BodyHomeView(
                    modifier = Modifier.padding(innerPadding),
                    onClick = onDetailClick,
                    onDosen = onDosen,
                    onMK = onMK
                )

            }
        }
    )
}

