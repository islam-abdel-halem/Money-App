package com.example.moneyapp.ui.commonUi.textFields


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneyapp.R

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String,
    message: String,
    value: String,
    imageRes: Painter = painterResource(id = R.drawable.ic_email),
    trailingIconOn: Boolean = false,
    isPassord: Boolean = false,
    onValueChange: (String) -> Unit = {},
    onClick: () -> Unit = {},
    isReadOnly: Boolean = false
) {
    var passwordVisible by remember { mutableStateOf(false) }
    val passwordIcon = if (passwordVisible) painterResource(id = R.drawable.ic_close_eye)
    else painterResource(id = R.drawable.ic_open_eye)
    Column {
        Text(
            text = text,
            modifier = modifier
                .align(Alignment.Start)
                .padding( top = 8.dp)

        )

        OutlinedTextField(
            label = {
                Text(
                    text = message,
                    fontSize = 16.sp,
                    color = Color.Black.copy(alpha = 0.5f)

                )
            },
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() },
            shape = RoundedCornerShape(8.dp),
            readOnly = isReadOnly,
            trailingIcon = {


                if (trailingIconOn && !isPassord)
                    Image(
                        painter = imageRes,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 15.dp)
                            .size(24.dp)
                            .clickable {
                                onClick()
                            }
                            .alpha(0.6f)

                    )
                if (isPassord)
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Image(
                            painter = passwordIcon,
                            contentDescription = "",
                            modifier = Modifier
                                .padding(end = 15.dp)
                                .size(24.dp)
                                .alpha(0.6f)
                        )
                    }
            },
            visualTransformation = if (passwordVisible || !isPassord) VisualTransformation.None else PasswordVisualTransformation(),

            )
    }
}
