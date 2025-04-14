package app.ntech.localsearch

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import com.google.gson.Gson
import java.io.IOException
import java.nio.charset.StandardCharsets

class CommonUtils {

    companion object{
        fun getMenuJsonForAssociate(activity: Activity, fileName: String): HomepageData {

            val gson = Gson()
            val json = loadJSONFromAsset(activity, fileName)
            val topic = gson.fromJson(json, HomepageData::class.java)
            Log.d("chan","exception : "+topic.toString())
            //  val addlist : StatesList = topic
            return topic;
        }

        fun loadJSONFromAsset(context: Context?, fileName: String): String? {
            var json: String? = null

            if (context == null) {
                return json
            }
            try {
                val `is` = context.assets.open(fileName)
                val size = `is`.available()
                val buffer = ByteArray(size)
                `is`.read(buffer)
                `is`.close()
                json = String(buffer, StandardCharsets.UTF_8)
            } catch (ex: IOException) {
                Log.e("loadjson", ex.stackTrace.toString())
                return null
            }
            return json
        }

        fun isConnected(context: Context): Boolean {

            // register activity with the connectivity manager service
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            // if the android version is equal to M
            // or greater we need to use the
            // NetworkCapabilities to check what type of
            // network has the internet connection
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                // Returns a Network object corresponding to
                // the currently active default data network.
                val network = connectivityManager.activeNetwork ?: return false

                // Representation of the capabilities of an active network.
                val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

                return when {
                    // Indicates this network uses a Wi-Fi transport,
                    // or WiFi has network connectivity
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                    // Indicates this network uses a Cellular transport. or
                    // Cellular has network connectivity
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                    // else return false
                    else -> false
                }
            } else {
                // if the android version is below M
                @Suppress("DEPRECATION") val networkInfo =
                    connectivityManager.activeNetworkInfo ?: return false
                @Suppress("DEPRECATION")
                return networkInfo.isConnected
            }
        }
    }
}
