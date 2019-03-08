package atlassianmobilefinder.com.store.reducer

import atlassianmobilefinder.com.store.*

abstract class Reducer<in T : Action> {

    open fun reduce(action: T, currentState: State) =
            with(currentState) {
                currentState.copy(
                        itemsListScreen
                )
            }

    open fun reduceItemsListScreen(action: T, itemsListScreen: ItemsListScreen) =
            itemsListScreen.copy(items = reduceItemsCollection(action, itemsListScreen.items))

    open fun reduceItemsCollection(action: T, currentItems: List<Item>) =
            currentItems.findAndMap(
                    find = { shouldReduceItem(action, it) },
                    map = { changeItemFields(action, it) }
            )

    open fun reduceEditItemScreen(action: T, editItemScreen: EditItemScreen) =
            editItemScreen.copy(
                    currentItem = reduceCurrentItem(action, editItemScreen.currentItem))

    open fun reduceCurrentItem(action: T, currentItem: Item) =
            if (shouldReduceItem(action, currentItem)) changeItemFields(action, currentItem)
            else currentItem

    open fun shouldReduceItem(action: T, currentItem: Item) = false
    open fun changeItemFields(action: T, currentItem: Item) = currentItem
    open fun reduceNavigation(action: T, currentNavigation: Navigation) = currentNavigation


}