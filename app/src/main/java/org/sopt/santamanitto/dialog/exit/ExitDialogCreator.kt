package org.sopt.santamanitto.dialog.exit

import android.content.Context
import androidx.fragment.app.DialogFragment
import org.sopt.santamanitto.R
import org.sopt.santamanitto.dialog.RoundDialogBuilder

object ExitDialogCreator {
    fun create(
        context: Context, roomName: String, isHost: Boolean, listener: (() -> Unit)
    ): DialogFragment {
        val message = if (isHost) {
            context.getString(R.string.exit_dialog_host)
        } else {
            String.format(context.getString(R.string.exit_dialog_guest), roomName)
        }
        return RoundDialogBuilder()
            .setContentText(message)
            .addHorizontalButton(context.getString(R.string.dialog_cancel))
            .addHorizontalButton(context.getString(R.string.dialog_confirm)) {
                listener()
            }
            .build()
    }

}