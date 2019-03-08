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

import atlassianmobilefinder.com.store.Item
import atlassianmobilefinder.com.store.Navigation
import atlassianmobilefinder.com.store.ReadAction


object ReadReducer : Reducer<ReadAction>() {

    override fun reduceItemsCollection(action: ReadAction, currentItems: List<Item>): List<Item> =
            when (action) {
                is ReadAction.ItemsLoadedAction -> action.items
                else -> super.reduceItemsCollection(action, currentItems)
            }

    override fun reduceCurrentItem(action: ReadAction, currentItem: Item): Item =
            Item()

    override fun reduceNavigation(action: ReadAction, currentNavigation: Navigation): Navigation =
            Navigation.ITEMS_LIST

}