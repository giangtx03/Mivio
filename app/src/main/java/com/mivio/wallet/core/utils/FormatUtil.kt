package com.mivio.wallet.core.utils

fun Int.formatAmount(): String {
    return "%,d".format(this)
}