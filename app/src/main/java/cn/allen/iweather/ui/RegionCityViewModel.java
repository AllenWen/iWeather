package cn.allen.iweather.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import cn.allen.iweather.persistence.entity.CityEntity;
import cn.allen.iweather.persistence.entity.FavoriteEntity;
import cn.allen.iweather.repository.CityRepository;
import cn.allen.iweather.repository.FavoriteRepository;

/**
 * Author: AllenWen
 * CreateTime: 2017/11/16
 * Email: wenxueguo@medlinker.com
 * Description:
 */

public class RegionCityViewModel extends ViewModel {

    public LiveData<List<String>> getCities(String province) {
        return CityRepository.getInstance().getCities(province);
    }

    public LiveData<List<CityEntity>> getMunicipalCounties(String province) {
        return CityRepository.getInstance().getMunicipalCounties(province);
    }

    public void insertFavorite(final FavoriteEntity favoriteEntity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                FavoriteRepository.getInstance().insertFavorite(favoriteEntity);
            }
        }).start();
    }

}
