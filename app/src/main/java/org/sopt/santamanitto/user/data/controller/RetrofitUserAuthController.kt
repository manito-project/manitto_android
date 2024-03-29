package org.sopt.santamanitto.user.data.controller

import org.sopt.santamanitto.network.RequestCallback
import org.sopt.santamanitto.network.start
import org.sopt.santamanitto.user.data.UserInfoResponse
import org.sopt.santamanitto.user.mypage.UserNameRequest
import org.sopt.santamanitto.user.mypage.UserNameResponse
import org.sopt.santamanitto.user.network.UserAuthService

class RetrofitUserAuthController(private val userAuthService: UserAuthService): UserAuthController {
    override fun changeUserName(userId: Int, newName: String, callback: (isSuccess: Boolean) -> Unit) {
        userAuthService.changeUserName(userId, UserNameRequest(newName)).start(object: RequestCallback<UserNameResponse> {
            override fun onSuccess(data: UserNameResponse) {
                callback.invoke(true)
            }

            override fun onFail() {
                callback.invoke(false)
            }
        })
    }

    override fun getUserInfo(userId: Int, callback: UserAuthController.GetUserInfoCallback) {
        userAuthService.getUserInfo(userId).start(object : RequestCallback<UserInfoResponse> {
            override fun onSuccess(data: UserInfoResponse) {
                callback.onUserInfoLoaded(data)
            }

            override fun onFail() {
                callback.onDataNotAvailable()
            }
        })
    }
}