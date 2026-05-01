package com.mivio.wallet.core.designsystem.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mivio.wallet.core.designsystem.theme.BorderColor
import com.mivio.wallet.core.designsystem.theme.Dimens
import com.mivio.wallet.core.designsystem.theme.TextSecondary
import com.mivio.wallet.core.designsystem.theme.Typography

@Composable
fun InsightCard(modifier: Modifier = Modifier, serial: Int, description: String) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(Dimens.spacing_tiny),
        horizontalArrangement = Arrangement.spacedBy(Dimens.spacing_small),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(Dimens.icon_medium)
                .border(
                    width = Dimens.border_width,
                    color = BorderColor,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = serial.toString(),
                style = Typography.labelSmall,
                color = TextSecondary
            )
        }
        Text(
            text = description,
            style = Typography.bodyMedium,
            color = TextSecondary,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
private fun InsightCardPreview() {
    Column(modifier = Modifier.background(Color.White)) {
        InsightCard(
            modifier = Modifier,
            1,
            "Chi phí ăn uống tháng này tăng 20%. Hãy cân nhắc nấu ăn ở nhà"
        )
    }
}