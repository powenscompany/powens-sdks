package com.powens.sdk.infrastructure

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation class Parcelize()

expect interface Parcelable
