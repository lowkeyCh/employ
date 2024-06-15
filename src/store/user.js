import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', {
    state: () => ({
        user: {
            userName: '',
            userPassword: '',
            userIdentity: '',
        }
    }),
    actions: {
        setUser(user) {
            this.user.userName = user.userName
            this.user.userPassword = user.userPassword
            this.user.userIdentity = user.userIdentity
        }
    },
    persist: {
        enabled: true,  // true 表示开启持久化保存
        strategies: [
            {storage: localStorage}
        ]
    }
})
