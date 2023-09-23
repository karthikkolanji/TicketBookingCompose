package com.vmware.ticketbooking.utils

import com.vmware.ticketbooking.utils.Const.HOME_SCREEN

sealed class Route(val route: String) {
    data object BookSeat : Route(HOME_SCREEN)
}
