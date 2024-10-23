package com.powens.sdk.client

internal fun getPowensDomainRoot(domain: String): String {
    // Domains must use lowercase letters, digits and hyphens
    require(domain.matches("[a-z\\d]+(-[a-z\\d]+)*".toRegex())) { "Invalid domain" }
    return "https://${domain}.biapi.pro/2.0/"
}

internal fun validateClientId(clientId: String) {
    // Client IDs must be digits-only
    require(clientId.matches("\\d+".toRegex())) { "Invalid client ID: $clientId" }
}