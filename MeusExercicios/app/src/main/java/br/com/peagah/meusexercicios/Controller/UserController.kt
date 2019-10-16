package br.com.peagah.meusexercicios.Controller

    fun validateUser(userLogin: String, userPassword: String) : Boolean{
        var isCanConnect = true

        if (userLogin.isBlank()){
            isCanConnect = false
        }
        if (userPassword.isBlank()){
            isCanConnect = false
        }

        return isCanConnect
    }