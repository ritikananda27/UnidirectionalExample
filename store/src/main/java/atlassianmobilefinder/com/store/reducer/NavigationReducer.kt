/**
 * Copyright (C) 2017 Cesar Valiente & Corey Shaw
 *
 * https://github.com/CesarValiente
 * https://github.com/coshaw
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package atlassianmobilefinder.com.store.reducer

import atlassianmobilefinder.com.store.EditItemScreen
import atlassianmobilefinder.com.store.Navigation
import atlassianmobilefinder.com.store.NavigationAction
object NavigationReducer : Reducer<NavigationAction>() {

    override fun reduceEditItemScreen(action: NavigationAction, editItemScreen: EditItemScreen): EditItemScreen =
            when (action) {
                is NavigationAction.EditItemScreenAction -> editItemScreen.copy(
                        currentItem = action.item)
                else -> super.reduceEditItemScreen(action, editItemScreen)
            }

    override fun reduceNavigation(action: NavigationAction, currentNavigation: Navigation): Navigation =
            when (action) {
                is NavigationAction.EditItemScreenAction -> Navigation.EDIT_ITEM
                is NavigationAction.ItemsScreenAction -> Navigation.ITEMS_LIST
            }
}