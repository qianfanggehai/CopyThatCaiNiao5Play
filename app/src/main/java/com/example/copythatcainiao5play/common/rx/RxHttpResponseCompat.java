package com.example.copythatcainiao5play.common.rx;

import com.example.copythatcainiao5play.bean.BaseBean;
import com.example.copythatcainiao5play.common.exception.ApiException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RxHttpResponseCompat {

    public static <T> Observable.Transformer<BaseBean<T>,T> compatResult(){


        return new Observable.Transformer<BaseBean<T>, T>(){

            @Override
            public Observable<T> call(Observable<BaseBean<T>> baseBeanObservable) {


                return baseBeanObservable.flatMap((Func1<BaseBean<T>, Observable<T>>) tBaseBean -> {

                    if (tBaseBean.success()){

                        return Observable.create((Observable.OnSubscribe<T>) subscriber -> {

                            try {
                                subscriber.onNext(tBaseBean.getData());
                                subscriber.onCompleted();
                            }catch (Exception e){
                                subscriber.onError(e);
                            }
                        });

                    }else {
                        return Observable.error(new ApiException(tBaseBean.getStatus(),tBaseBean.getMessage()));
                    }
//                        return null;
                }).observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
