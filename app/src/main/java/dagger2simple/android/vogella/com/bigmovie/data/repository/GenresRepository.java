package dagger2simple.android.vogella.com.bigmovie.data.repository;

import java.util.Map;

import dagger2simple.android.vogella.com.bigmovie.data.model.Genre;
import rx.Observable;

/**
 * Created by khoalevan on 3/29/17.
 */

public interface GenresRepository {

    Observable<Map<Integer, Genre>> genres();
}
