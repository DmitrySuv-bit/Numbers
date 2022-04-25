package ru.nsk.suvorov.numbers.app

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.android.support.DaggerAppCompatActivity
import ru.nsk.suvorov.numbers.app.ui.theme.NumbersTheme
import ru.nsk.suvorov.numbers.component.ui.ViewModelFactory
import ru.nsk.suvorov.numbers.feature.numberfact.presentation.NumberFactViewModel
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

	@Inject
	lateinit var viewModelFactory: ViewModelFactory

	private val viewModel: NumberFactViewModel by viewModels(::viewModelFactory)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			NumbersTheme {

				NumberScreen(viewModel = viewModel)
			}
		}
	}
}

@Composable
fun NumberScreen(viewModel: NumberFactViewModel) {

	val systemUiController = rememberSystemUiController()
	val bacColor = MaterialTheme.colors.background

	SideEffect {
		systemUiController.setSystemBarsColor(color = bacColor)
	}

	val ddList = viewModel.listFacts.collectAsState()

	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colors.background
	) {
		Column(
			modifier = Modifier.padding(20.dp))
		{
			Button(
				onClick = viewModel::update,
				contentPadding = PaddingValues(
					start = 20.dp,
					top = 12.dp,
					end = 20.dp,
					bottom = 12.dp
				),
				modifier = Modifier.fillMaxWidth(),
				shape = MaterialTheme.shapes.large
			) {
				Text(text = "Добавить факт")
			}

			LazyColumn {
				items(ddList.value) { item ->
					Card(
						shape = MaterialTheme.shapes.large,
						backgroundColor = MaterialTheme.colors.secondary,
						elevation = 5.dp,
						modifier = Modifier
							.fillMaxWidth()
							.padding(top = 10.dp, bottom = 10.dp)
					) {
						Text(
							modifier = Modifier.padding(10.dp, 5.dp),
							text = item,
							textAlign = TextAlign.Center
						)
					}

				}
			}
		}
	}
}