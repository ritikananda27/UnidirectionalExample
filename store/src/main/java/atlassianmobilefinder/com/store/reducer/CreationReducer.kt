package atlassianmobilefinder.com.store.reducer

import atlassianmobilefinder.com.store.CreationAction
import atlassianmobilefinder.com.store.CreationAction.CreateItemAction
import atlassianmobilefinder.com.store.Item

object CreationReducer : Reducer<CreationAction>() {

    override fun reduceItemsCollection(action: CreationAction, currentItems: List<Item>) =
            when (action) {
                is CreateItemAction -> currentItems + createNewItem(action)
            }

    private fun createNewItem(action: CreateItemAction): Item =
            with(action) {
                Item(localId, text, favorite, color, position)
            }

}