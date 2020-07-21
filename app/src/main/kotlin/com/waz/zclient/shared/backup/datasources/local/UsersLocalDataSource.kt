package com.waz.zclient.shared.backup.datasources.local

import com.waz.zclient.storage.db.users.model.UserEntity
import com.waz.zclient.storage.db.users.service.UserDao
import kotlinx.serialization.Serializable

class UsersLocalDataSource(dao: UserDao, batchSize: Int = BatchSize) :
BackupLocalDataSource<UserEntity, UserJSONEntity>("users", dao, batchSize, UserJSONEntity.serializer()) {
    override fun toJSON(entity: UserEntity) = UserJSONEntity.from(entity)
    override fun toEntity(json: UserJSONEntity) = json.toEntity()
}

@Serializable
data class UserJSONEntity(
    val id: String,
    val teamId: String? = null,
    val name: String = "",
    val email: String? = null,
    val phone: String? = null,
    val trackingId: String? = null,
    val picture: String? = null,
    val accentId: Int = 0,
    val sKey: String = "",
    val connection: String = "",
    val connectionTimestamp: Int = 0,
    val connectionMessage: String? = null,
    val conversation: String? = null,
    val relation: String = "",
    val timestamp: Int? = null,
    val verified: String? = null,
    val deleted: Boolean = false,
    val availability: Int = 0,
    val handle: String? = null,
    val providerId: String? = null,
    val integrationId: String? = null,
    val expiresAt: Int? = null,
    val managedBy: String? = null,
    val selfPermission: Int = 0,
    val copyPermission: Int = 0,
    val createdBy: String? = null
) {
    fun toEntity() = UserEntity(
        id = id,
        teamId = teamId,
        name = name,
        email = email,
        phone = phone,
        trackingId = trackingId,
        picture = picture,
        accentId = accentId,
        sKey = sKey,
        connection = connection,
        connectionTimestamp = connectionTimestamp,
        connectionMessage = connectionMessage,
        conversation = conversation,
        relation = relation,
        timestamp = timestamp,
        verified = verified,
        deleted = deleted,
        availability = availability,
        handle = handle,
        providerId = providerId,
        integrationId = integrationId,
        expiresAt = expiresAt,
        managedBy = managedBy,
        selfPermission = selfPermission,
        copyPermission = copyPermission,
        createdBy = createdBy
    )

    companion object {
        fun from(entity: UserEntity) = UserJSONEntity(
            id = entity.id,
            teamId = entity.teamId,
            name = entity.name,
            email = entity.email,
            phone = entity.phone,
            trackingId = entity.trackingId,
            picture = entity.picture,
            accentId = entity.accentId,
            sKey = entity.sKey,
            connection = entity.connection,
            connectionTimestamp = entity.connectionTimestamp,
            connectionMessage = entity.connectionMessage,
            conversation = entity.conversation,
            relation = entity.relation,
            timestamp = entity.timestamp,
            verified = entity.verified,
            deleted = entity.deleted,
            availability = entity.availability,
            handle = entity.handle,
            providerId = entity.providerId,
            integrationId = entity.integrationId,
            expiresAt = entity.expiresAt,
            managedBy = entity.managedBy,
            selfPermission = entity.selfPermission,
            copyPermission = entity.copyPermission,
            createdBy = entity.createdBy
        )
    }
}
