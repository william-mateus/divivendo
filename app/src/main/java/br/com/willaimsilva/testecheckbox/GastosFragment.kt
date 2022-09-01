package br.com.willaimsilva.testecheckbox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.willaimsilva.testecheckbox.databinding.ActivityMainBinding
import br.com.willaimsilva.testecheckbox.databinding.FragmentGastosBinding
import com.google.android.material.snackbar.Snackbar

class GastosFragment : Fragment() {

    private lateinit var binding: FragmentGastosBinding

    private fun validarCampo(piranha: String?): Boolean {
        return piranha.isNullOrEmpty() || piranha.toFloatOrNull() == null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGastosBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.somar.setOnClickListener {
            if (validarCampo(binding.capital.text.toString())) {
                Snackbar.make(it, "coloque seu salario", Snackbar.LENGTH_SHORT).show()
            } else {
                val capital = binding.capital.text.toString().toFloatOrNull() ?: 0f
                val fatura = binding.fatura.text.toString().toFloatOrNull() ?: 0f
                val luz = binding.luz.text.toString().toFloatOrNull() ?: 0f
                val agua = binding.agua.text.toString().toFloatOrNull() ?: 0f

                val total = capital - fatura - luz - agua

                Snackbar.make(it, "após pagar suas contas irá sobrar :R$$total", Snackbar.LENGTH_SHORT).show()
            }
        }

    }

}