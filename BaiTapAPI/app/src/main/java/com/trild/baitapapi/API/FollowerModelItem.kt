package com.trild.baitapapi.API

data class FollowerModelItem(
    val avatar_url: String?, // https://avatars.githubusercontent.com/u/61400883?v=4
    val events_url: String?, // https://api.github.com/users/ChloeTruong210/events{/privacy}
    val followers_url: String?, // https://api.github.com/users/ChloeTruong210/followers
    val following_url: String?, // https://api.github.com/users/ChloeTruong210/following{/other_user}
    val gists_url: String?, // https://api.github.com/users/ChloeTruong210/gists{/gist_id}
    val gravatar_id: String?,
    val html_url: String?, // https://github.com/ChloeTruong210
    val id: Int?, // 61400883
    val login: String?, // ChloeTruong210
    val node_id: String?, // MDQ6VXNlcjYxNDAwODgz
    val organizations_url: String?, // https://api.github.com/users/ChloeTruong210/orgs
    val received_events_url: String?, // https://api.github.com/users/ChloeTruong210/received_events
    val repos_url: String?, // https://api.github.com/users/ChloeTruong210/repos
    val site_admin: Boolean?, // false
    val starred_url: String?, // https://api.github.com/users/ChloeTruong210/starred{/owner}{/repo}
    val subscriptions_url: String?, // https://api.github.com/users/ChloeTruong210/subscriptions
    val type: String?, // User
    val url: String? // https://api.github.com/users/ChloeTruong210
)