package com.mivio.wallet.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mivio.wallet.core.designsystem.components.HeaderTitle
import com.mivio.wallet.core.designsystem.components.cards.CategoryDropZone
import com.mivio.wallet.core.designsystem.components.cards.CategoryDropZoneUiState
import com.mivio.wallet.core.designsystem.components.cards.SummaryCard
import com.mivio.wallet.core.designsystem.components.cards.TransactionItem
import com.mivio.wallet.core.designsystem.components.cards.TransactionItemUiState
import com.mivio.wallet.core.designsystem.theme.Background
import com.mivio.wallet.core.designsystem.theme.CatHouse
import com.mivio.wallet.core.designsystem.theme.Dimens
import com.mivio.wallet.core.designsystem.theme.DividerColor
import com.mivio.wallet.core.designsystem.theme.Primary
import com.mivio.wallet.core.designsystem.theme.SurfaceVariant
import com.mivio.wallet.core.designsystem.theme.TextPrimary
import com.mivio.wallet.core.designsystem.theme.Typography

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.spacing_small)
        ) {
            HeaderTitle(
                modifier = Modifier.padding(
                    top = Dimens.spacing_tiny,
                ),
                title = "Trang chủ",
                icons = listOf(Icons.Filled.DateRange, Icons.Filled.Settings)
            )

            SummaryCard(
                modifier = Modifier.padding(horizontal = Dimens.spacing_medium),
                amount = 16000000,
                spent = 250000
            )

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = Dimens.radius_xlarge,
                            topEnd = Dimens.radius_xlarge
                        )
                    )
                    .background(Background)
                    .padding(
                        top = Dimens.spacing_medium,
                        start = Dimens.spacing_medium,
                        end = Dimens.spacing_medium,
                        bottom = Dimens.spacing_tiny
                    )
            ) {
                ProcessingTransactionList(
                    transactions = listOf(
                        TransactionItemUiState(
                            Icons.Filled.Person,
                            "VCB",
                            "05/01/2026, 12:00",
                            10000000,
                            true
                        ),
                        TransactionItemUiState(
                            Icons.Filled.Settings,
                            "VCB",
                            "05/01/2026, 12:00",
                            10000000,
                            false
                        ),
                        TransactionItemUiState(
                            Icons.Filled.Settings,
                            "VCB",
                            "05/01/2026, 12:00",
                            10000000,
                            false
                        ),
                        TransactionItemUiState(
                            Icons.Filled.Settings,
                            "VCB",
                            "05/01/2026, 12:00",
                            10000000,
                            false
                        ),
                        TransactionItemUiState(
                            Icons.Filled.Favorite,
                            "VCB",
                            "05/01/2026, 12:00",
                            10000000,
                            true
                        )
                    )
                )

                HorizontalDivider(
                    thickness = Dimens.divider_thickness,
                    color = DividerColor
                )

                CategoryList(
                    modifier = Modifier.padding(top = Dimens.spacing_medium),
                    categories = listOf(
                        CategoryDropZoneUiState(
                            image = Icons.Filled.Home,
                            background = CatHouse,
                            category = "Thuê nhà"
                        ),
                        CategoryDropZoneUiState(
                            image = Icons.Filled.Home,
                            background = CatHouse,
                            category = "Thuê nhà"
                        ),
                        CategoryDropZoneUiState(
                            image = Icons.Filled.Home,
                            background = CatHouse,
                            category = "Thuê nhà"
                        ),
                        CategoryDropZoneUiState(
                            image = Icons.Filled.Home,
                            background = CatHouse,
                            category = "Thuê nhà"
                        ),
                        CategoryDropZoneUiState(
                            image = Icons.Filled.Home,
                            background = CatHouse,
                            category = "Thuê nhà"
                        )
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen()
}

@Composable
fun ProcessingTransactionList(
    modifier: Modifier = Modifier,
    transactions: List<TransactionItemUiState>,
    height: Dp = Dimens.transaction_height * 3
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Dimens.spacing_small)
    ) {
        Text(text = "Sổ chờ xử lý", color = TextPrimary, style = Typography.titleMedium)
        Text(text = "Giao dịch chờ phân loại", color = TextPrimary, style = Typography.titleSmall)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(height),
        ) {
            items(transactions) { it ->
                TransactionItem(
                    Modifier,
                    state = it
                )
            }
        }
    }
}

@Composable
fun CategoryList(
    modifier: Modifier = Modifier,
    categories: List<CategoryDropZoneUiState>,
    height: Dp = Dimens.drop_zone_size * 2 + Dimens.spacing_medium
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Dimens.spacing_small)
    ) {
        Text(
            text = "Danh mục của tôi",
            color = TextPrimary,
            style = Typography.titleMedium
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxWidth()
                .height(height),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalArrangement = Arrangement.spacedBy(Dimens.spacing_medium),
        ) {
            items(categories) { categoryState ->
                CategoryDropZone(
                    modifier = Modifier.wrapContentSize(Alignment.Center), state = categoryState
                )
            }
            item {
                CategoryDropZone(
                    modifier = Modifier.wrapContentSize(Alignment.Center),
                    state = CategoryDropZoneUiState(
                        image = Icons.Filled.Add,
                        background = SurfaceVariant,
                        category = ""
                    )
                )
            }
        }
    }
}