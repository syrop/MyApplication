package pl.org.seva.myapplication.main

import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.WorkerThread
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV
import androidx.security.crypto.EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
import androidx.security.crypto.MasterKeys
import pl.org.seva.myapplication.main.init.Bootstrap
import javax.crypto.AEADBadTagException

object SecuredSharedPreferences {

    private val bootstrap by instance<Bootstrap>()
    private var sharedPreferences: SharedPreferences? = null

    @WorkerThread
    @Synchronized
    fun getInstance(): SharedPreferences {
        if (sharedPreferences == null) {
            val storeName = "AuthState"
            val context = bootstrap.context

            try {
                val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
                sharedPreferences = EncryptedSharedPreferences.create(
                    storeName,
                    masterKeyAlias,
                    context,
                    AES256_SIV,
                    AES256_GCM
                )
                println("wiktor [getInstance] encrypted shared preferences")

                sharedPreferences ?: throw IllegalStateException()

            }
            catch (e: AEADBadTagException) {
                println("wiktor aha!!!")
                e.printStackTrace()
                null!! // crash the app anyway
            }
            catch (e: Exception) {
                println("wiktor [getInstance] fallback to non-encrypted shared preferences")
                sharedPreferences = context.getSharedPreferences(storeName, Context.MODE_PRIVATE)
            }
        }

        return sharedPreferences ?: throw IllegalStateException()
    }
}
