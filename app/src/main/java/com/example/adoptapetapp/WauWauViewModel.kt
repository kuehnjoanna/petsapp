package com.example.adoptapetapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adoptapetapp.data.Datasource
import com.example.adoptapetapp.data.Message
import com.example.adoptapetapp.data.Pet

class WauWauViewModel: ViewModel() {

    val allPets: List<Pet> = Datasource.data
    var allMessages: MutableList<Message> = Datasource.messages.toMutableList()
    val allFavProfiles: MutableList<Pet> = Datasource.favorites.toMutableList()
    private var _password = MutableLiveData<String>("")
    private var _login = MutableLiveData<String>("")
    private val _pets = MutableLiveData<List<Pet>>(allPets)
    private val _messages = MutableLiveData<List<Message>>(allMessages)
    private val _favorites = MutableLiveData<List<Pet>>(allFavProfiles)
    val pets: LiveData<List<Pet>>
        get() = _pets
    val messages: LiveData<List<Message>>
        get() = _messages
    val login: LiveData<String>
        get() = _login
    val password: LiveData<String>
        get() = _password

    val favorites: LiveData<List<Pet>>
        get() = _favorites
    val selectedPetItem = MutableLiveData<Pet>()
    val selectedMessageItem = MutableLiveData<Message>()



    fun selectedPetItem(it: Pet){
        selectedPetItem.value = it
    }
    fun selectedMessageItem(it: Message){
        selectedMessageItem.value = it
    }
    fun addPetToFav(){
        allFavProfiles.add(selectedPetItem.value!!)
    }
    fun removePetFromFav(){
        allFavProfiles.remove(selectedPetItem.value!!)
    }
    fun removeMessageFromInbox(){
        allMessages.remove(selectedMessageItem.value!!)
    }
    fun addMessageToInbox(message: Message){
        allMessages.add(message)
        Log.d("messages", "$allMessages")
    }

    fun filterPets(gender: String){
        val newList = allPets.filter {
            it.gender.equals(gender)
        }
        _pets.value = newList
    }
    fun filterPetsAge(number: Int){
        val newerList = allPets.filter {
            it.age.equals(number)

        }
        _pets.value = newerList

    }
    fun filterAdultsPetsAge(){
        val newerList = allPets.filter {
            it.age.equals(2) || it.age.equals(3) || it.age.equals(4) ||
                    it.age.equals(6) || it.age.equals(7) || it.age.equals(8) ||
                    it.age.equals(9)

        }
        _pets.value = newerList

    }
    fun filterSeniorPetsAge(){
        val newerList = allPets.filter {
            it.age.equals(11) || it.age.equals(12) || it.age.equals(13) ||
                    it.age.equals(10)

        }
        _pets.value = newerList

    }
    fun resetFilter(){
        _pets.value = allPets
    }
    fun addPasswordAndLogin(password: String, login: String){
        _login.value = login

    }
}