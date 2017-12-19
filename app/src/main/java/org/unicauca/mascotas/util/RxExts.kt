package org.unicauca.mascotas.util

import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Flowable<T>.applySchedulers() = compose {
    it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.applySchedulers() = compose {
    it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

fun AppCompatActivity.validateForm(@StringRes msg: Int, vararg fields: String) =
        Observable.create<List<String>> {
            if (fields.contains("")) Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            else it.onNext(fields.toList())
            it.onComplete()
        }

fun <T> AppCompatActivity.snackBarAction(view: View, @StringRes msg: Int, @StringRes action: Int
                                         , data: T) = Observable.create<T> { emitter ->
    Snackbar.make(view, msg, Snackbar.LENGTH_LONG)
            .setAction(action) {
                emitter.onNext(data)
                emitter.onComplete()
            }
            .show()



}