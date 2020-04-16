package com.waz.db.migration

import com.waz.KotlinMigrationHelper
import com.waz.model.PushNotificationEvents.PushNotificationEventsDao
import com.waz.model.{PushNotificationEvent, Uid}
import com.waz.utils.wrappers.{DB, SQLiteDBWrapper}
import com.waz.zclient.storage.db.notifications.PushNotificationEventEntity
import org.json.JSONObject

class PushNotificationEventsMigrationTest extends MigrationTest {
  feature("PushNotificationEvents table migration") {
    scenario("PushNotificationEvents migration with default values") {
      implicit val db: DB = new SQLiteDBWrapper(zMessagingDB.getWritableDatabase)
      val pushNotificationEvent = PushNotificationEvent(Uid(), 1, event = new JSONObject(), transient = false)
      PushNotificationEventsDao.insertOrReplace(Seq(pushNotificationEvent))
      closeDB()
      withRoomDB({
        KotlinMigrationHelper.assertPushNotEventEntity(_, new PushNotificationEventEntity(
          1, pushNotificationEvent.pushId.str, false, "{}", null, false
        ))
      })
    }
  }
}
