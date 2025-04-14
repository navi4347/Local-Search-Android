package app.ntech.localsearch


data class HomepageData(
    val categorylist: List<CategoryList>
)

data class CategoryList(
    val icon: String,
    val name: String
)