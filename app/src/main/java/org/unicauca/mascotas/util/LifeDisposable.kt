package org.unicauca.mascotas.util

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by darfe on 14/12/2017.
 */
class LifeDisposable(owner: LifecycleOwner):LifecycleObserver{

    init{
        owner.lifecycle.addObserver(this)
    }

    private val dis:CompositeDisposable = CompositeDisposable()

    infix fun add(disposable:Disposable){
        dis.add(disposable)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun dispose(){
        dis.clear()
    }

}