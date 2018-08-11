package com.zzq58.mvps.base;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter<V> {

    protected V mView;
    private CompositeSubscription compositeSubscription;

    private CompositeDisposable compositeDisposable;

    public BasePresenter(V v) {
        this.mView = v;
    }

    public void detachView() {
        mView = null;
        onUnsubscribe();
    }

    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    public void addSubscription(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

}
