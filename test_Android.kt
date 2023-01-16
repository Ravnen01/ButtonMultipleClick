import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/*
ClickCountingTextView is a special kind of TextView, that is supposed to:

- Execute onSuccess() if the view is clicked |n| times within a period of |timeLimitInMillis| (from first click to nth click).

- Execute onTimeout() if the time defined by |timeLimitInMillis| is up and the number of clicks did not reach |n|

The timer only restarts after onTimeout was called and a new click has occurred. (onClick() has been called at least once)

After calling onSuccess any further clicks should have no effect. */

class ClickCountingTextView constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    private val n: Int = 10,
    private val timeLimitInMillis: Long = 5000,
    private val onSuccess: () -> Unit,
    private val onTimeout: () -> Unit = {}
) : AppCompatTextView(context, attrs, defStyleAttr){

}

@Composable
fun ClickCountingTextView(
    text: String,
    n: Int = 10,
    timeLimitInMillis: Long = 5000,
    modifier: Modifier = Modifier,
    onSuccess: () -> Unit = { },
    onTimeout: () -> Unit = { }
) {
    Text(text = text)
}