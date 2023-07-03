package com.step.krm.logapp.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.step.krm.logapp.R
import com.step.krm.logapp.data.LogDTO
import com.step.krm.logapp.data.LogRepository
import java.sql.Date
import java.sql.Timestamp


@Composable
fun ButtonPage(repository: LogRepository, toLogs: () -> Unit) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.buttons_welcome),
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(20.dp)
            )

            SimpleButton(
                onClick = { repository.addLog(1) },
                text = stringResource(id = R.string.button_1)
            )
            SimpleButton(
                onClick = { repository.addLog(2) },
                text = stringResource(id = R.string.button_2)
            )
            SimpleButton(
                onClick = { repository.addLog(3) },
                text = stringResource(id = R.string.button_3)
            )
            SimpleButton(onClick = toLogs, text = stringResource(id = R.string.see_all_logs))
            SimpleButton(
                onClick = { repository.removeAllLogs() },
                text = stringResource(id = R.string.delete_logs)
            )

        }
    }
}

@Composable
fun SimpleButton(onClick: () -> Unit, text: String) {
    Button(
        onClick = onClick, modifier = Modifier
            .padding(20.dp)
    ) {
        Text(text = text)
    }
}

@Composable
fun LogList(logs: List<LogDTO>) {
    MaterialTheme {
        LazyColumn {
            items(
                items = logs,
                key = { task -> task.id }
            ) { log ->
                val stamp = Timestamp(log.timestamp)
                val date = Date(stamp.time)
                Text(
                    text = "${log.id}) Button with ID - ${log.buttonId} clicked on $date",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}