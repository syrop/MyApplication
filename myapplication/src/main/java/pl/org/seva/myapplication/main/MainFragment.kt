package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import pl.org.seva.myapplication.R


class MainFragment : Fragment(R.layout.fr_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val json = "{\"threadId\":1,\"data\":{\"peerId\":1,\"aggregateId\":5134,\"senderId\":29,\"type\":\"pubsub.object-created\",\"object\":{\"peerId\":1,\"senderId\":29,\"uiId\":\"5910bc72-6e66-46db-a6a4-8747725d310a\",\"id\":5134,\"siteInfo\":null,\"content\":\"2\"},\"objectType\":\"message\"},\"sound\":\"default\",\"imageUrl\":null,\"type\":\"NativePushNotification\",\"title\":\"Hillary Clinton\",\"body\":\"2\"}"
        println("wiktor json: $json")
        val obj = JsonParser.parseString(json) as JsonObject
        obj.addProperty("timestamp", System.currentTimeMillis())
        println("wiktor obj $obj")
    }
}
