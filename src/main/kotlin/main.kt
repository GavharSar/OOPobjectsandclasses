package ru.netology

data class Post(
    val id: Int = 0,
    val authorId: Int,
    val authorName: String,
    val content: String,
    val publish: Long,
    val likes: Int = 0,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val canPin: Boolean = true,
    val friendsOnly: Boolean = false
)

class Comments(
    var count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

class Likes(
    var count: Int,
    val userLikes: Boolean
)

object WallService {

    private var posts = emptyArray<Post>()
    private var nextId = mutableSetOf<Int>()

    fun add(post: Post): Post {
        posts += post
        nextId.add(post.id)
        return posts.last()
    }

    fun update(postOrigin: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == postOrigin.id) {
                posts[index] = post.copy(likes = postOrigin.likes, friendsOnly = postOrigin.friendsOnly)
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        nextId.clear()
    }
}

fun main() {
    var post = Post(1, 3, "Masha", "Post", 120322, 5)
    var post2 = Post(2,6,"Misha", "Content", 51021)
    WallService.add(post)
    println(post)
}

