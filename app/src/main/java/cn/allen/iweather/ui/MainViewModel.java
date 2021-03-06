package cn.allen.iweather.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import cn.allen.iweather.persistence.entity.FavoriteEntity;
import cn.allen.iweather.repository.FavoriteRepository;
import cn.allen.iweather.repository.WeatherRepository;
import cn.allen.iweather.utils.Configs;
import cn.allen.iweather.webservice.ApiResponse;
import cn.allen.iweather.webservice.entity.BaseWrapperEntity;
import cn.allen.iweather.webservice.entity.WeatherNowEntity;

/**
 * Author: AllenWen
 * CreateTime: 2017/11/9
 * Email: wenxueguo@medlinker.com
 * Description:
 */

public class MainViewModel extends ViewModel {

    public LiveData<List<FavoriteEntity>> loadFavorites() {
        return FavoriteRepository.getInstance().loadFavorites();
    }

    public LiveData<ApiResponse<BaseWrapperEntity<WeatherNowEntity>>> now(String location) {
        return WeatherRepository.getInstance().now(Configs.KEY, location, Configs.LANG, Configs.UNIT);
    }

    public void deleteFavorite(final String id) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                FavoriteRepository.getInstance().deleteFavorite(id);
            }
        }).start();
    }

}
