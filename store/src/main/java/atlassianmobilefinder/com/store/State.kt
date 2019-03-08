package atlassianmobilefinder.com.store


enum class Navigation {
    ITEMS_LIST,
    EDIT_ITEM
}

data class ItemListScreen(val items: List<Item> = emptyList())

data class EditItemScreen(val currentItem: Item = Item())


data class State(
    val itemsListScreen: ItemListScreen = ItemListScreen(),
    val editItemScreen: EditItemScreen = EditItemScreen(),
    val navigation: Navigation = Navigation.ITEMS_LIST
)