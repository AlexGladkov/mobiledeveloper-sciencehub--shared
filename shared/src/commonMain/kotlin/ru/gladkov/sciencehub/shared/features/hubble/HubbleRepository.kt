package ru.gladkov.sciencehub.shared.features.hubble

class HubbleRepository(
    private val remoteDataSource: HubbleRemoteDataSource
) {

    suspend fun fetchNews() = remoteDataSource.fetchNews()
}