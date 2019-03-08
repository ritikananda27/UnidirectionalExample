package atlassianmobilefinder.com.store


enum class Navigation {
    ITEMS_LIST,
    EDIT_ITEM
}

data class ItemsListScreen(val items: List<Item> = emptyList())

data class EditItemScreen(val currentItem: Item = Item())


data class State(
        val itemsListScreen: ItemsListScreen = ItemsListScreen(),
        val editItemScreen: EditItemScreen = EditItemScreen(),
        val navigation: Navigation = Navigation.ITEMS_LIST
)