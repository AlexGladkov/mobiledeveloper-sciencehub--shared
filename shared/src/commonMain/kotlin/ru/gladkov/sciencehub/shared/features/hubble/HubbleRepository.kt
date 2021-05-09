package ru.gladkov.sciencehub.shared.features.hubble

class HubbleRepository(
    private val remoteDataSource: HubbleRemoteDataSource
) {

    suspend fun fetchNews() = remoteDataSource.fetchNews()
    suspend fun getNew(id: String) = remoteDataSource.getNew(id)
}