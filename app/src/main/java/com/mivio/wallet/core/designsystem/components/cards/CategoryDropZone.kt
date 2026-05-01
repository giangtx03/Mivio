package com.mivio.wallet.core.designsystem.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mivio.wallet.core.designsystem.theme.CatHouse
import com.mivio.wallet.core.designsystem.theme.Dimens
import com.mivio.wallet.core.designsystem.theme.TextPrimary
import com.mivio.wallet.core.designsystem.theme.Typography

@Composable
fun CategoryDropZone(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    image: ImageVector,
    category: String
) {
    Box(
        modifier = modifier
            .size(Dimens.drop_zone_size)
            .clip(RoundedCornerShape(Dimens.radius_medium))
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.spacing_tiny)
        ) {
            Icon(
                imageVector = image,
                contentDescription = category,
                tint = TextPrimary
            )
            Text(text = category, color = TextPrimary, style = Typography.labelSmall)
        }
    }
}

@Preview
@Composable
private fun CategoryDropZonePre() {
    CategoryDropZone(
        modifier = Modifier,
        backgroundColor = CatHouse,
        image = Icons.Filled.Home,
        category = "Thuê nhà"
    )
}