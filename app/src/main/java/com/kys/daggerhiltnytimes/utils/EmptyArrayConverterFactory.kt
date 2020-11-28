package com.kys.daggerhiltnytimes.utils

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type


class EmptyArrayConverterFactory : Converter.Factory() {

    override fun responseBodyConverter(type: Type, annotations: Array<Annotation>, retrofit: Retrofit): Converter<ResponseBody, *>? {
        val delegate = retrofit.nextResponseBodyConverter<Any>(this, type, annotations)
        return Converter<ResponseBody, Any> { body ->
            var bodyString = body.string()
            if (bodyString == "[]") { // Or whatever the empty array is returned as
                bodyString = "empty"//Convert body string to empty/error TransactionModel JSON
            }
            delegate.convert(bodyString)
        }
    }

}

private fun <F, T> Converter<F, T>.convert(bodyString: T) {

}
