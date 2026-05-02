package com.mivio.wallet.core.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import com.mivio.wallet.core.designsystem.theme.Dimens
import com.mivio.wallet.core.designsystem.theme.TextPrimary
import com.mivio.wallet.core.designsystem.theme.Typography

@Composable
fun HeaderTitle(modifier: Modifier = Modifier, title: String, icons: List<ImageVector>) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(Dimens.spacing_small),
        horizontalArrangement = Arrangement.spacedBy(Dimens.spacing_tiny),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            modifier = Modifier.weight(1f),
            color = TextPrimary,
            style = Typography.titleLarge,
            textAlign = TextAlign.Start
        )
        icons.forEach {
            Icon(
                imageVector = it,
                contentDescription = it.name,
                modifier = Modifier.size(
                    Dimens.icon_medium
                )
            )
        }
    }
}