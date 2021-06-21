package com.trild.baitapapi.Model

data class FollowingModelItem(
    val avatar_url: String?, // https://avatars.githubusercontent.com/u/5754972?v=4
    val events_url: String?, // https://api.github.com/users/florent37/events{/privacy}
    val followers_url: String?, // https://api.github.com/users/florent37/followers
    val following_url: String?, // https://api.github.com/users/florent37/following{/other_user}
    val gists_url: String?, // https://api.github.com/users/florent37/gists{/gist_id}
    val gravatar_id: String?,
    val html_url: String?, // https://github.com/florent37
    val id: Int?, // 5754972
    val login: String?, // florent37
    val node_id: String?, // MDQ6VXNlcjU3NTQ5NzI=
    val organizations_url: String?, // https://api.github.com/users/florent37/orgs
    val received_events_url: String?, // https://api.github.com/users/florent37/received_events
    val repos_url: String?, // https://api.github.com/users/florent37/repos
    val site_admin: Boolean?, // false
    val starred_url: String?, // https://api.github.com/users/florent37/starred{/owner}{/repo}
    val subscriptions_url: String?, // https://api.github.com/users/florent37/subscriptions
    val type: String?, // User
    val url: String? // https://api.github.com/users/florent37
)