package org.sopt.santamanitto.room.manittoroom

import android.view.View
import android.view.ViewGroup
import org.sopt.santamanitto.R
import org.sopt.santamanitto.databinding.ItemResultBinding
import org.sopt.santamanitto.room.manittoroom.network.ManittoRoomMember
import org.sopt.santamanitto.user.data.UserInfoResponse
import org.sopt.santamanitto.user.data.controller.UserAuthController
import org.sopt.santamanitto.view.recyclerview.BaseViewHolder

class ResultViewHolder(
    parent: ViewGroup,
    private val userAuthController: UserAuthController,
) : BaseViewHolder<ManittoRoomMember, ItemResultBinding>(R.layout.item_result, parent) {

    override fun bind(data: ManittoRoomMember) {
        binding.textviewItemresultSanta.text = data.userName

        userAuthController.getUserInfo(data.relations.manittoUserId, object : UserAuthController.GetUserInfoCallback {
            override fun onUserInfoLoaded(userInfoResponse: UserInfoResponse) {
                binding.run {
                    textviewItemresultMinitto.text = userInfoResponse.userName
                    santaloadingItemresult.visibility = View.GONE
                }
            }

            override fun onDataNotAvailable() {
                binding.santaloadingItemresult.setError(true)
            }
        })
    }
}