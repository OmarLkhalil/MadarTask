package com.omarlkhalil.domain.exceptions


sealed class ValidationException : Exception() {
    data object InValidNameException : ValidationException()
    data object InValidAgeException : ValidationException()
    data object InvalidEmailException : ValidationException()
    data object InvalidGenderExcepetion : ValidationException()
}
