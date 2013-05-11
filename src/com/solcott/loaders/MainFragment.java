package com.solcott.loaders;

import android.app.Fragment;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.AsyncTaskLoader;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.solcott.loaders.R;

public class MainFragment extends Fragment implements LoaderCallbacks<Integer> {

	private static int NEXT_VAL = 0;

	TextView text1;

	Button button1;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getLoaderManager().initLoader(1, null, this);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_main, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		text1 = (TextView) view.findViewById(android.R.id.text1);
		button1 = (Button) view.findViewById(android.R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(), NextActivity.class));
			}
		});
	}

	@Override
	public Loader<Integer> onCreateLoader(int id, Bundle args) {
		AsyncTaskLoader<Integer> loader = new AsyncTaskLoader<Integer>(
				getActivity()) {

			@Override
			public Integer loadInBackground() {
				return NEXT_VAL++;
			}
		};
		loader.forceLoad();
		return loader;
	}

	@Override
	public void onLoadFinished(Loader<Integer> loader, Integer data) {
		text1.setText(data.toString());
	}

	@Override
	public void onLoaderReset(Loader<Integer> loader) {
		// TODO Auto-generated method stub

	}

}
