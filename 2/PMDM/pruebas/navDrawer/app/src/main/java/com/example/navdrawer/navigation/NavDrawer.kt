package com.example.navdrawer.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navdrawer.navigationItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun NavDrawer(
    drawerState: DrawerState,
    scope: CoroutineScope,
    selectedItemIndex: MutableState<Int>
){
    ModalNavigationDrawer(
        drawerContent = {
            // Drawer content
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                navigationItems.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = {
                            Text(text = item.title)
                        },
                        selected = index == selectedItemIndex.value,
                        onClick = {
                            selectedItemIndex.value = index
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = if(index == selectedItemIndex.value) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        },
                        badge = {
                            if (item.badgeCount > 0) {
                                Text(text = item.badgeCount.toString())
                            }
                        },
                        modifier = Modifier
                            .padding(NavigationDrawerItemDefaults.ItemPadding)

                    )
                }
            }
        },
        drawerState = drawerState
    ) {
        // detras deñ drawer
        Scaffold(
            topBar = {
                TopBar{
                    // Open drawer
                    scope.launch {
                        drawerState.open()
                    }
                }
            },
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = it.calculateTopPadding())
                ){
                    HomeScreen()
                }

            }
        )
    }
}