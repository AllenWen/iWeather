package cn.allen.iweather.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import cn.allen.iweather.persistence.database.AppDatabase;
import cn.allen.iweather.persistence.entity.CityEntity;
import cn.allen.iweather.webservice.ApiResponse;
import cn.allen.iweather.webservice.Network;
import cn.allen.iweather.webservice.entity.BaseWrapperEntity;
import cn.allen.iweather.webservice.entity.LocationEntity;

/**
 * Author: AllenWen
 * CreateTime: 2017/11/9
 * Email: wenxueguo@medlinker.com
 * Description:
 */

public class CityRepository {

    private static CityRepository mInstance;

    public static CityRepository getInstance() {
        if (mInstance == null) {
            mInstance = new CityRepository();
        }
        return mInstance;
    }

    public LiveData<List<String>> getProvinces(String country_name) {
        return AppDatabase.getInstance().cityDao().getProvinces(country_name);
    }

    public LiveData<List<String>> getCities(String province_zh) {
        return AppDatabase.getInstance().cityDao().getCities(province_zh);
    }

    public LiveData<List<CityEntity>> getCounties(String city_zh) {
        return AppDatabase.getInstance().cityDao().getCounties(city_zh);
    }

    public LiveData<List<CityEntity>> getMunicipalCounties(String province_zh) {
        return AppDatabase.getInstance().cityDao().getMunicipalCounties(province_zh);
    }

    public LiveData<ApiResponse<BaseWrapperEntity<LocationEntity>>> searchCity(String key, String q, String language, int limit, int offset) {
        return Network.instance().getApi().searchCity(key, q, language, limit, offset);
    }

}
