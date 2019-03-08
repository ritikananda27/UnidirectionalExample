package atlassianmobilefinder.com.store

sealed class Action


sealed class NavigationAction : Action() {
    data class EditItemScreenAction(val item: Item) : NavigationAction()
    class ItemsScreenAction : NavigationAction()

}

sealed class ReadAction : Action() {
    class FetchItemsAction : ReadAction()
    data class ItemsLoadedAction(val items: List<Item>) : ReadAction()
}

sealed class CreationAction : Action() {
    data class CreateItemAction(
        val localId: String, val text: String, val favorite: Boolean = false,
        val color: Color1, val position: Long
    ) : CreationAction()
}


sealed class UpdateAction : Action() {
    data class ReorderItemsAction(val items: List<Item>) : UpdateAction()

    data class UpdateItemAction(
        val localId: String,
        val text: String,
        val color: Color1
    ) : UpdateAction()

    data class UpdateFavoriteAction(val localId: String, val favorite: Boolean) : UpdateAction()

    data class UpdateColorAction(val localId: String, val color: Color1) : UpdateAction()
}

sealed class DeleteAction : Action() {
    data class DeleteItemAction(val localId: String) : DeleteAction()
}