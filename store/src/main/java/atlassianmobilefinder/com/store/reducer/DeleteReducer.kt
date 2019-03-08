package atlassianmobilefinder.com.store.reducer

import atlassianmobilefinder.com.store.DeleteAction
import atlassianmobilefinder.com.store.DeleteAction.DeleteItemAction
import atlassianmobilefinder.com.store.Item

object DeleteReducer : Reducer<DeleteAction>() {

    override fun reduceItemsCollection(action: DeleteAction, currentItems: List<Item>): List<Item> =
            when (action) {
                is DeleteItemAction -> currentItems.filterNot { it.localId == action.localId }
            }

    override fun reduceCurrentItem(action: DeleteAction, currentItem: Item): Item =
            when (action) {
                is DeleteItemAction -> if (action.localId == currentItem.localId) Item() else currentItem
            }

}